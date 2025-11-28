#ifndef MODULE_H
#define MODULE_H

#include <string>

class module {
	std::string moduleCode;
	std::string moduleName;
	int credits;

public:
	
	//module();

	module(const std::string &code, const std::string &name, const int &creds);

	std::string displayModuleInfo() const;

	int getCredits() const { return credits; };

	std::string getModuleCode() const { return moduleCode; };

};

#endif 

