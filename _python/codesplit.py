"""
split binary string into blocks of n
"""
import math
from IPython.Debugger import Tracer; debug_here = Tracer()

def split(codestr, blockSize):
    numBlocks = float(len(codestr))/blockSize
    bidx      = 0
    codes     = []
    while (bidx) < (len(codestr)):
        codes.append(codestr[bidx:(bidx+blockSize)])
        bidx += blockSize
    return codes
    
def toInt(codes, base):
    ints = []
    for i in codes[:]:
        ints.append(int(i,base))
    return ints

def binstrlist2hex(binlist):
    hexstr = []
    for b in binlist[:]:
        hexstr.append(hex(int(b,2)))
    return hexstr
    
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

def splitbin(codestr):
    slist = []
    tmp   = codestr[0]
    buf   = []
    for i in range(len(codestr)):
        if tmp == codestr[i]:
            buf.append(codestr[i])
        else:
            #if not buf:
            #    buf.append(tmp)
            slist.append(''.join(buf))
            buf = []
            buf.append(codestr[i])
        tmp = codestr[i]
    return slist
