#ifndef STUDENT_H
#define STUDENT_H

#include "termGrades.h"
#include <map>
#include <vector>


class student {
	int studentId;
	std::map<int, termGrades> termGradesRecord;

public:

	student(const int& id);

	const int& getId() { return studentId; }

	void addGrades(const int& term, const termGrades& termGrad);
		
};


#endif 
