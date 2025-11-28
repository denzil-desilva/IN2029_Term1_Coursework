#include "termGrades.h"

using namespace std;

termGrades::termGrades(const int& code, const std::string& modCode, const int& grade):
	termCode(code){
	grades[modCode] = grade;
}

void termGrades::addGrade(const string& modCode, const int& grade) {
	grades[modCode] = grade;
}

