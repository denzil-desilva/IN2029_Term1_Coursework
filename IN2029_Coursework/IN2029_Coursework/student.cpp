#include "student.h"
#include "termGrades.h"

student::student(const int& id) :
	studentId(id){}


void student::addGrades(const int& term, const termGrades& termGrad) {
	termGradesRecord.insert({ term, termGrad });
}
