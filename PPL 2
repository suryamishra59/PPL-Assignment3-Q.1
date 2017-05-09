#include <iostream>
#include <fstream>
#include <string>
using namespace std;
char line[100];
inti;
	char ch;
	string value,lang;
ifstreamifile,rfile,cfile;
ofstreamofile,oufile,outfile;
void result();
void clear();
void finale();
int main () 
{
	cout<<"reading from infile.txt";
	result();
	cout<<"copying value to cleared.txt";
	clear();
	cout<<"prepare final file final.bat\n";
	finale();
return 0;
}	
void result()
 {		ifile.open ("test.txt",ios::in); 
		ofile.open ("result.txt",ios::trunc|ios::out);
		cout<<"enter line to copy(f/m/r/s):";
		cin>>ch;				
		while(!ifile.eof())
		{	ifile.getline(line,100);
			if(line[9]==ch)
			{
				ofile<<line<<endl;				
			}			
			for(i=0;i<100;i++)
			{
				line[i]='\0';
			}		
		}
		cout<<"done\n";  
		ifile.close();
		ofile.close();
	}
void clear()
	{
		rfile.open("result.txt",ios::in);
		oufile.open("cleared.txt",ios::trunc|ios::out);
		cout<<"copying value\n ";
		while(!rfile.eof())
		{     			rfile.getline(line,100);
			for(i=13;i<100;i++)
			{	oufile<<line[i];
		    }
		oufile<<endl;		
		for(i=0;i<100;i++)
			{
				line[i]='\0';
			}			
	   }
		cout<<"done\n"; 
		rfile.close();
		oufile.close();
	}
void finale()
{		cfile.open ("cleared.txt",ios::in); 
		outfile.open ("final.bat",ios::trunc|ios::out);
		cout<<"program wanted to associate\n";
		cin>>lang;
		while(!cfile.eof())
		{
		cfile.getline(line,100);
			outfile<<lang<<line<<endl;
			for(i=0;i<100;i++)
			{
				line[i]='\0';
			}
		}
		cout<<"done\n"; 
		cfile.close();
		outfile.close();
}
