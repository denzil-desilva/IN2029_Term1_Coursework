#include <iostream>
#include <fstream>
#include <string>

using namespace std;


int main() {

	ifstream input;

	input.open("grades.txt");

	string x;
	string y;
	string z;
	string a;
	string b;

	while (input >> x >> y >> z >> a >> b) {

		cout << x << " " << y << " " << z << " " << a << " " << b << "\n";

	}

	input.close();


	return 0;

}



