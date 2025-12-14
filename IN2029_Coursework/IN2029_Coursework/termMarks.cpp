#include "termMarks.h"
#include "student.h"
#include <iostream>

using namespace std;

//termMarks::termMarks() :
//	termCode(0) {
//	addMark("0", 0, 0);
//}

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

void termMarks::displayTermReport(map<string, module>& moduleRecord) {

	cout << "  Term " << getTermCode() << ":\n";

	for (auto &it : marksRecord) {
		cout << "    " << moduleRecord.at(it.first).getModuleInfo() << ":" << it.second;
	}
}

//double getOverallAverage(const student& student) {
//	vector<int>& sums = student.getAllTermSums();
//	return sums[0] / sums[1];
//}

