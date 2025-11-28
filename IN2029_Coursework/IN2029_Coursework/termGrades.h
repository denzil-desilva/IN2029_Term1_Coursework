#ifndef TERMGRADES_H
#define TERMGRADES_H

#include "module.h"
#include <map>
#include <string>

class termGrades {
	int termCode;
	std::map<std::string, int> grades;

public:

	termGrades(const int &code, const std::string &modCode, const int &grade);

	void addGrade(const std::string& modCode, const int &grade);

	//void addModule(const module& module);
};

#endif

