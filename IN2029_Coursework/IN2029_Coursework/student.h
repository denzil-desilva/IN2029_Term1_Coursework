#ifndef STUDENT_H
#define STUDENT_H

#include "termMarks.h"
#include <map>
#include <vector>


class student {
	int studentId;
	std::map<int, termMarks> termMarksRecord;

public:

	student(const int& id);

	const int& getId() { return studentId; }

	void addMarks(const int& term, const termMarks& termMark);

	std::vector<int>& getAllTermSums() const;

	termMarks& getTermMarks(const int& termCode) {
		return termMarksRecord.at(termCode);
	}

};


#endif 
