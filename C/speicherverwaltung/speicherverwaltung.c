#include <stdio.h>
#include <stddef.h>
#include "speicherverwaltung/speicherverwaltung.h"

char mempool[MEM_POOL_SIZE];
memblock *freemem;

/**
* Initialisiert den simulierten heap
*/
int cm_init(void) {
    static int init_count = 1;

    if (init_count == 0) {
        return init_count;
    }

    freemem = (memblock*) mempool;

    freemem->id = 0;
    freemem->next = NULL;
    freemem->size = MEM_POOL_SIZE - sizeof(memblock);

    init_count = 0;
    return 1;
}

/**
* Alloziert den Speicherbereich mit der gewaehlten Groesse
* @param size Groesse des Blockes in bytes
* @return Gibt den Anfang des nutzbaren Bereich als Pointer zurueck, 
* falls es keine passende Groesse gibt oder NULL uebergeben wird,
* wird ein NULL Pointer zurueckgegeben
*/
void *cm_malloc(size_t size) {
    if (size == 0 ||
        freemem == NULL ||
        (memblock*)mempool > freemem ||
        (memblock*)(mempool + MEM_POOL_SIZE) < freemem) {

        return NULL;
    }

    memblock *pointer = freemem;
    static unsigned short id = 1;

    while (pointer->size < size && pointer->next != NULL) {
        if (pointer->next == (void*) MAGIC_INT) {
            return NULL;
        }
        pointer = pointer->next;
    }

    if (pointer->size < size || 
        (memblock*)mempool > pointer ||
        (memblock*)(mempool + MEM_POOL_SIZE) < pointer) {

        return NULL;
    }

    #ifdef MALLOCSPLIT
    if (pointer->size > size + 2*sizeof(memblock) + 32) {

        memblock *newPointer = (memblock*)((char*)pointer + sizeof(memblock) + size);

        newPointer->size = pointer->size - size - sizeof(memblock);

        if (freemem == pointer) {
            freemem = newPointer;
        } else {
            memblock *prevPointer = freemem;

            while (prevPointer->next == pointer->next) {
                prevPointer = prevPointer->next;
            }

            prevPointer->next = newPointer;
        }

        newPointer->next = pointer->next;
        pointer->size = size;
    } else 
    #endif
    if (freemem == pointer) {
        if (pointer->next == NULL) {
            freemem = NULL;
        } else {
            freemem = pointer->next;
        }
    } else {
        memblock *prevPointer = freemem;

        while (prevPointer->next != pointer) {
            prevPointer = prevPointer->next;
        }

        prevPointer->next = pointer->next;
    }


    pointer->next = (void*) MAGIC_INT;
    pointer->id = id;
    ++id;

    return (memblock*)((char*)pointer + sizeof(memblock));
}

/**
* Stellt den uebergebenen Block wieder zur verfuegung
* @param ptr Den Anfang des nutzbaren Bereich als Pointer
*/
void cm_free(void *ptr) {
    if (ptr == NULL ||
        (void*)mempool > ptr ||
        (void*)(mempool + MEM_POOL_SIZE) < ptr) {

        return;
    }

    memblock *pointer = (memblock*)((char*)ptr - sizeof(memblock));

    if (pointer->next != (memblock*)MAGIC_INT) {
        return;
    }

    pointer->next = freemem;
    freemem = pointer;
}