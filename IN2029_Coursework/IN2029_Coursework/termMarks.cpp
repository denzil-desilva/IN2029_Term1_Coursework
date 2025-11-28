#include "termMarks.h"
#include "student.h"
#include "iostream"

using namespace std;

termMarks::termMarks(const int& code) :
	termCode(code){
}

void termMarks::addMark(const string& modCode, const int& mark, const int& credits) {
	marksRecord[modCode] = mark;
	updateSums(mark, credits);
}

int termMarks::getTermAverage() const{
	
	return marksAndCreditsSum / creditsSum;
	
}

void termMarks::updateSums(const int& mark, const int& credits) {
	marksAndCreditsSum += (mark*credits);
	creditsSum += credits;
}

double getOverallAverage(const student& student) {

	vector<int>& sums = student.getOverallTermSums();

	return sums[0] / sums[1];
}

