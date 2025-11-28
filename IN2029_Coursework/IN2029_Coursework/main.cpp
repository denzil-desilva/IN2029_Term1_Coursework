#include "student.h"
#include "module.h"
#include "termGrades.h"
#include <iostream>
#include <fstream>
#include <string>
#include <map>

using namespace std;


int main() {

	map<string, module> moduleRecord;

	map<int, student> studentRecord;

	ifstream input("modules.txt");

	string x;
	string a;
	string b;
	string c;

	//<< " " << a << " " << b << " " << c

	while (input >> a >> b >> c) {
		moduleRecord.insert({a, module(a, c, stoi(b))});

		cout << moduleRecord.empty();
	}

	return 0;

}



