"""
Make a histogram of normally distributed random numbers and plot the
analytic PDF over it
"""
import matplotlib.pyplot as plt

def hist(data, bins=10, normed=0, xlabel="", ylabel=""):
    fig = plt.figure()
    ax  = fig.add_subplot(111)

    # the histogram of the data
    n, bins = ax.hist(data, 50, normed=0, facecolor='blue', alpha=0.75)

    ax.set_xlabel('symbols')
    ax.set_ylabel('Probability')
    ax.set_xlim(min(data), max(data))
    ax.set_ylim(0, max(n))
    ax.grid(True)

    plt.draw()
    #plt.draw()
