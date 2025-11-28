#ifndef TERMMARKS_H
#define TERMMARKS_H

#include "student.h"
#include <map>
#include <string>

class termMarks {
	int termCode;
	std::map<std::string, int> marksRecord;

	int marksAndCreditsSum = 0;
	int creditsSum = 0;

public:

	termMarks(const int &code);

	void addMark(const std::string& modCode, const int &mark, const int &credits);

	int getTermAverage() const;

	int getMarksAndCreditsSum() const{ return marksAndCreditsSum; };

	int getCreditsSum() const{ return creditsSum; };

private:

	void updateSums(const int& mark, const int& credits);
};

double getOverallAverage(const student &student);

#endif

