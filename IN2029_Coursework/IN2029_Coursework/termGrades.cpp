#include "termGrades.h"
#include "iostream"

using namespace std;

termGrades::termGrades(const int& code, const std::string& modCode, const int& grade):
	termCode(code){
	grades[modCode] = grade;
}

void termGrades::addGrade(const string& modCode, const int& grade) {
	grades[modCode] = grade;
}

int termGrades::getTermAverage() const{

	int gradeSum = 0;

	for (auto it = grades.cbegin(); it != grades.cend(); ++it) {
		auto map_element = *it;
		
		gradeSum += map_element.second;
	}
}

