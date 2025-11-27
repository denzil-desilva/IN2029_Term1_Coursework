#ifndef MODULE_H
#define MODULE_H

#include <string>

class module {
	std::string moduleCode;
	std::string moduleName;
	int credits;

public:
	std::string displayModuleInfo() {
		return "null";
	}

	int getCredits() {
		return 0;
	}

	std::string getModuleCode() {
		return "null";
	}
};

#endif 

