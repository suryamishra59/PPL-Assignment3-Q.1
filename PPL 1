#include<iostream>
using namespace std;
 struct boggy
{	
int value;
    struct boggy *next;
} Boggy;
int lgth( boggy * head )
{
int l = 0;
    boggy * current  = head;
    while(current)
{
l++;
        current = current->next;
    }
    return l;
}
void addRemainingDigits(boggy *L1, int *carry, boggy **result, int diff);
void addListRecursively(boggy *L1, boggy *L2, int *carry, boggy **result);
boggy * createBoggy(int value)
{  
    boggy * newBoggy = (boggy *)malloc(sizeof(boggy));
newBoggy->value = value;
newBoggy->next = NULL;  
    return newBoggy;  
}
 void push(boggy **head, int value)
 {
    boggy *newBoggy = createBoggy (value);
    if(!(*head) ){
        *head = newBoggy;
    }
    else{
newBoggy->next = (*head);
        *head = newBoggy;
    }
}
void addTwoNo(boggy *L1, boggy *L2, int *carry, boggy  **result)
{
int l1 = lgth( L1 );
int l2 = lgth( L2 );
int diff = 0;  
    if(l1 < l2)
    {
        boggy * current = L1;
        L1 = L2;
        L2 = current;
    }
    diff = abs(l1-l2);
    boggy * current = L1;  
    while(diff--)
        current = current->next;
addListRecursively(current, L2, carry, result);
  diff = abs(l1-l2);
addRemainingDigits(L1, carry, result, diff);
  if(*carry)
  {
        push(result, *carry);
   }
    return;
} 
void addListRecursively(boggy *L1, boggy *L2, int *carry, boggy **result)
{  
int sum;
        if(!L1)
            return;  
addListRecursively(L1->next, L2->next, carry, result);  
         sum = L1->value + L2->value + (*carry);  
int value = sum%10;
        *carry = sum/10;
        push(result, value);  
        return;
} 
void addRemainingDigits(boggy *L1, int *carry, boggy **result, int diff){
int sum = 0;  
    if(!L1 || !diff)
        return;
addRemainingDigits(L1->next, carry, result, diff-1);  
    sum = L1->value + (*carry);
int value = sum%10;
    *carry = sum/10;  
    push(result, value);  
    return;
}
void printList( boggy * head ){
    boggy * current = head;
    while(current){
cout<<current->value;
        current = current->next;
    }
}
int main(){
	int v1,v2,n1,n2;
	int ch1=1,ch2=1;
        boggy * L1 = NULL;
        boggy * L2 = NULL;
        boggy * result = NULL;
int carry = 0 ;
cout<<"minimum lgth of 1st infinite number\n";
cin>>n1;
cout<<"enter the 1st number in reverse order\n";
        for(inti=0;i<n1-1;i++)
        {cin>>v1;
        push(&L1,v1);} 
        while(ch1==1)
        { 
		cin>>v1;
        push(&L1,v1);
cout<<"want to enter more(1/0)\n";
cin>>ch1;
        }
cout<<"minimum lgth of 2nd infinite number in reverse order\n";
cin>>n2;
cout<<"enter the 2nd number\n";
        for(int j=0;j<n2-1;j++)
        {cin>>v2;
        push(&L2,v2);}
        while(ch2==1)
        {
cin>>v2;
        push(&L2,v2);
cout<<"want to enter more(1/0)\n";
cin>>ch2;
        }
cout<<"1st number\n";
printList(L1);
cout<<"\n";
cout<<"2nd number\n";
printList(L2);
cout<<"\n";
addTwoNo(L1,L2, &carry, &result);
printList(result);
cout<<"\n";
        return 0;
}
