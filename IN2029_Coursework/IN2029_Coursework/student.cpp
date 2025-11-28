#include "student.h"
#include "termMarks.h"
#include <vector>

using namespace std;

student::student(const int& id) :
	studentId(id){}


void student::addMarks(const int& term, const termMarks& termMark) {
	termMarksRecord.insert({ term, termMark });
}

vector<int>& student::getOverallTermSums() const{

	vector<int> sums = { 0, 0 };

	for (auto it = termMarksRecord.cbegin(); it != termMarksRecord.cend(); ++it) {
		auto& tempTermMarks = *it;
		sums[0] += tempTermMarks.second.getMarksAndCreditsSum();
		sums[1] += tempTermMarks.second.getCreditsSum();
	}

	return sums;

}
