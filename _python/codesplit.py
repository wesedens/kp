"""
split binary string into blocks of n
"""
import math

def split(codestr, blockSize):
    numBlocks = len(codestr)/blockSize
    bidx      = 0
    codes     = []
    for i in range(int(math.ceil(numBlocks))):
        codes.append(codestr[bidx:bidx+blockSize])
        bidx += blockSize
        #print "{0}".format(codes[i])
    return codes
    
def toInt(codes, base):
    ints = []
    for i in codes[:]:
        ints.append(int(i,base))
    return ints

def charlist2int(clist):
    ints = []
    for ch in clist[:]:
        ints.append(ord(ch))
    return ints

def int2chrlist(ilist):
    clist = []
    for i in ilist[:]:
        clist.append(str(unichr(lfreqi[i])))
    return clist