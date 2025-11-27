#include <iostream>
#include <fstream>
#include <string>

using namespace std;


int main() {

	ifstream input("requests.txt");

	string x;

	while (input >> x) {
		cout << x <<"\n";
	}

	return 0;

}



