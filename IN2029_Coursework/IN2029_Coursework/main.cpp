#include "student.h"
#include "module.h"
#include "termMarks.h"
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

	while (getline(file_line, x)) {

		istringstream record(x);

		int studentId;
		int termCode;
		string moduleCode;
		int mark;

		while (record >> studentId >> termCode >> moduleCode >> mark) {

			if (studentRecord.find(studentId) != studentRecord.cend()) {
				student newStudent(studentId);
				newStudent.addMarks(termCode, termMarks(termCode));

				studentRecord.insert({ studentId, newStudent});
			}
			
			studentRecord.at(studentId).getTermMarks(termCode).addMark(moduleCode, mark, moduleRecord.at(moduleCode).getCredits());
			
		}


	}

	
}


int main() {

	map<string, module> moduleRecord;

	map<int, student> studentRecord;

	
	//readModules(moduleRecord);

	//readStudents(studentRecord, moduleRecord);
	//

	//studentRecord.at(20231234);


	return 0;

}



