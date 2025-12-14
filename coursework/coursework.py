import numpy as np
import matplotlib.pyplot as mlt


class windTurbinePowerTime:

    def __init__(self):

        file = np.loadtxt("windturbinepower.txt")

        self.times = file[:, 0]
        self.powers = file[:, 1]


    def getMaxPower(self):
        return np.amax(self.powers)

    def getMeanPower(self):
        return np.mean(self.powers)
    
    def getStandardDeviation(self):
        return np.std(self.powers)
    
    def plotGraph(self):

        mlt.figure(1)
        mlt.plot(self.times, 
                 self.powers, '-+r')
        
        deri = self.hello()

        mlt.plot(self.times, 
                 deri, '-+b')
        
        mlt.title("Power generated over time")
        mlt.xlabel("Time(s)")
        mlt.xlabel("Power(W)")
        mlt.show()

    def hello(self):

        # x = [0, 1, 2, 3, 4, 5, 6, 7, 8]
        # y= [4, 5, 12, 31, 68, 129, 220, 347, 516]

        dx = self.times[1] - self.times[0]

        dydx = []

        dydx.append((-3*self.powers[0] + 4*self.powers[1] - self.powers[2]) / (2*dx))
        dydx.append((-3*self.powers[1] + 4*self.powers[2] - self.powers[3]) / (2*dx))

        for n in range(2, len(self.powers)-2):
            dydx.append((8*self.powers[n+1] - 8*self.powers[n-1] - self.powers[n+2] + self.powers[n-2]) / (12*dx))

        N = len(self.powers)-2
        dydx.append((3*self.powers[N] - 4*self.powers[N-1] + self.powers[N-2]) / (2*dx))

        N = len(self.powers)-1
        dydx.append((3*self.powers[N] - 4*self.powers[N-1] + self.powers[N-2]) / (2*dx))
        
        return dydx


    
newClass = windTurbinePowerTime()
# print(newClass.getMeanPower())

newClass.plotGraph()

