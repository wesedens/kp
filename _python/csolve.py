"""
split binary string into blocks of n
"""
import math
import numpy as np

def getHdata(data):
    bins         = range(min(data),max(data)+2)
    hdata, nbins = np.histogram(data,bins)
    sidx         = np.argsort(hdata)[::-1]
    hdata        = hdata[sidx]
    nbins        = nbins[sidx]
    return hdata,nbins
    
def getFits(data, lfreq, order):
    hdata, nbins = getHdata(data)
    
    for i in range(len(hdata)):
        for j in range(i+1, len(hdata)):
            for k in range(len(lfreq)):
                coeff = np.polyfit(array([lfreq[i:i+2]]))        
    return 0

def solve(data, lfreq, didx):
    uniq        = unique(data)
    d           = data[:]
    hdata,nbins = getHdata(data)
    slist       = nbins[hdata.nonzero()]
    for i in range(len(didx)):
        d = replaceChar(d, slist[i], lfreq[didx[i]])
    writeToFile(d, 'dump')
    return d

def replaceChar(data, num2replace, chr):
    for i in range(len(data)):
        if data[i] == num2replace:
            data[i] = chr
    return data
 

def writeToFile(s, filename, title="", delimiter=""):
    with open(filename, 'w') as f:
        f.write(title)
        for i in s[:]:
            f.write(str(i))
            f.write(delimiter)
        f.write("\n\n")

def appendToFile(s, filename, title="", delimiter=""):
    with open(filename, 'a') as f:
        f.write(title)
        for i in s[:]:
            f.write(str(i))
            f.write(delimiter)
        f.write("\n\n")
    #f.closed
    
def unique(seq, keepstr=True):
  t = type(seq)
  if t in (str, unicode):
    t = (list, ''.join)[bool(keepstr)]
  seen = []
  return t(c for c in seq if not (c in seen or seen.append(c)))