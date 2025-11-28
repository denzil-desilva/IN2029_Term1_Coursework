#include "module.h"

using namespace std;

//module::module() :
//	moduleCode("0"), moduleName("N/A"), credits(0){ }

module::module(const std::string &code, const std::string &name, const int &creds):
	moduleCode(code), moduleName(name), credits(creds) {}

string module::displayModuleInfo() const {
	return moduleCode + " " + moduleName + " " + "(" + to_string(credits) + " credits)";
}
