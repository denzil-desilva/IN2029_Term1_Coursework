#ifndef TERMGRADES_H
#define TERMGRADES_H

#include "module.h"
#include <map>

class termGrades {
	int termCode;
	std::map<module, int> grades;

public:
	void addGrade(const module &module, const int &grade) {
		NULL;
	}

	void addModule(const module& module) {
		NULL;
	}
};

#endif

