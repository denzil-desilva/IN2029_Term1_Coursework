#include "student.h"
#include "module.h"
#include "termGrades.h"
#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include <map>

using namespace std;

void readModules(map<string, module> &moduleRecord) {

	ifstream input("modules.txt");

	string a;
	int b;
	string c;

	while (input >> a >> b >> c) {
		moduleRecord.insert({ a, module(a, c, b) });
	}
}

void readStudents(map<int, student>& studentRecord, map<string, module> &moduleRecord) {

	ifstream file_line("grades.txt");

	string x;

	int sumGrades;
	int sumCredits;

	while (getline(file_line, x)) {

		istringstream record(x);

		int studentId;
		int termCode;
		string moduleCode;
		int grade;

		while (record >> studentId >> termCode >> moduleCode >> grade) {

			sumGrades += grade;
			sumCredits += moduleRecord.at(moduleCode).getCredits();
			
			studentRecord.insert({ studentId, student(studentId) });

			studentRecord.at(studentId).addGrades(termCode, termGrades(termCode, moduleCode, grade));
		}


	}

	
}


int main() {

	map<string, module> moduleRecord;

	map<int, student> studentRecord;

	
	//readModules(moduleRecord);

	readStudents(studentRecord);
	

	studentRecord.at(20231234).getTermGrades(251);


	return 0;

}



