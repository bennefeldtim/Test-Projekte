#include "ledanzeige/TM1637.h"
#include <unistd.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>


typedef struct enrollment {
    int id;
    char name[3];
} enrollment;

typedef struct student{char name[20];struct enrollment *enrolled;int cps;} student;

typedef struct node{struct student *stdnt;struct node *next;struct node *prev;} node;

struct node *mainList;

int i = 0;


node *filterEnrollment(enrollment *filter) {
    node *currentNode = mainList;
    node *prevNode;
    node *newList = malloc(sizeof(struct node));
    int i = 0;
    
    while(currentNode != NULL) {
        //Filter alle Studenten mit einer bestimmten Studiengang id heraus
        if(currentNode->stdnt!=NULL&&currentNode->stdnt->enrolled->id == filter->id) {
            node *newNode = malloc(sizeof(struct node));
            //Setze Startknoten, falls dieser Leer
            if(newList==NULL||newList->stdnt==NULL){
                newNode->prev = 0;
                newList = newNode;
            }else{
                //Setze den nächsten und vorherigen Pointer
                newNode->prev = prevNode;
                prevNode->next = newNode;
            }
            //Verlinke den Studenten in der neuen Hilfsliste
            newNode->stdnt=currentNode->stdnt;
            newNode->next = 0;
            prevNode = newNode;
            i++;
        }

        currentNode = currentNode->next;
    }
    sleep(1);
    TM1637_setup();
    TM1637_brightness(DARK);
    TM1637_display_number(i);
    

    return newList;
}

void addNode(student *eingabe){
    TM1637_setup();
    TM1637_brightness(DARK);
    TM1637_display_number(i);
    node *newNode = malloc(sizeof(struct node));
    //Setze Startknoten, falls dieser Leer
    if(mainList==NULL||mainList->stdnt == NULL){
        mainList = newNode;
        newNode->prev = 0;
    }else{
        //Hänge den neuen Knoten an
        node *currentNode = mainList;
        while(currentNode->next != NULL){
                currentNode = currentNode->next;
        }
        newNode->prev = currentNode;
        currentNode->next = newNode;
    }
    i++;
    sleep(1);
    TM1637_display_number(i);
    newNode->stdnt= eingabe;
    newNode->next = 0;
}

void printList(struct node *list){
    node *currentNode = list;
        while(currentNode != NULL){
            printf("Name: %s | Studiengang: %s | CPS: %d\n",currentNode->stdnt->name,currentNode->stdnt->enrolled->name,currentNode->stdnt->cps);
                currentNode = currentNode->next;
        }
        printf("----------------------------------------------------------\n");
    }


void deleteSoftList(node *start){
    int i = 0;
    node *prevNode;
    node *currentNode = start;
    //Gehe durch alle Knoten durch
    while(currentNode != NULL){
        //Merke den vorherigen Knoten
        prevNode = currentNode;
        currentNode = currentNode->next;
        //Löscht den Knoten
        free(prevNode);
        i++;
    }
    sleep(1);
    TM1637_setup();
    TM1637_brightness(DARK);
    TM1637_display_number(i);
}

//void deleteList(){

//}

int main(){
    mainList = malloc(sizeof(struct node));
    node *ifmStudents;

    enrollment *ifm = malloc(sizeof(enrollment));
    ifm->id = 1;
    strcpy(ifm->name,"IFM");

    enrollment *mif = malloc(sizeof(enrollment));
    mif->id = 2;
    strcpy(mif->name,"MIF");

    
    student *s1=malloc(sizeof(student));
    strcpy(s1->name,"Tim Bennefeld");
    s1->enrolled = ifm;
    s1->cps=110;

    student *s2=malloc(sizeof(student));
    strcpy(s2->name,"Max Siemens");
    s2->enrolled = mif;
    s2->cps=120;
    
    student *s3=malloc(sizeof(student));
    strcpy(s3->name,"Rolf Strate");
    s3->enrolled = ifm;
    s3->cps=130;

    addNode(s1);
    addNode(s2);
    addNode(s3);

    printList(mainList);
    ifmStudents = filterEnrollment(ifm);
    printList(ifmStudents);
    deleteSoftList(ifmStudents);
    return 0;
}

