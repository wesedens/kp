"""
split binary string into blocks of n
"""
import math
import numpy as np
import sys

MORSE_CODES = {
    '.-':   u'a',  '--':   'm',   '-.--':  'y',
    '-...': u'b',  '-.':   'n',   '--..':  'z',
    '-.-.': u'c',  '---':  'o',   '.----': '1',
    '-..':  u'd',  '.--.': 'p',   '..---': '2',
    '.':    u'e',  '--.-': 'q',   '...--': '3',
    '..-.': u'f',  '.-.':  'r',   '....-': '4',
    '--.':  u'g',  '...':  's',   '.....': '5',
    '....': u'h',  '-':    't',   '-....': '6',
    '..':   u'i',  '..-':  'u',   '--...': '7',
    '.---': u'j',  '...-': 'v',   '---..': '8',
    '-.-':  u'k',  '.--':  'w',   '----.': '9',
    '.-..': u'l',  '-..-': 'x',   '-----': '0'
}

def decode(code):
    result = u""
    for symbol in code.split(u" "):
        result += symbol in MORSE_CODES and MORSE_CODES[symbol] or u'?'
    return result
            
    
def main():
    result = u""
    if len(sys.argv) > 1:
        coded_string = sys.argv[1]
        for symbol in coded_string.split(u" "):
            result += symbol in MORSE_CODES and MORSE_CODES[symbol] or u'?'

    print result


if __name__ == '__main__':
    main()
     
def decodelist(blist):
    for l in blist[:]:
        bin2morse(l)
        

def bin2morse(code):
    letters = code.split('000')
    for l in letters[:]:
        mor = l.split('0')
        m = []
        for mc in mor[:]:
            if mc == '1':
                m.append('.')
            else:
                m.append('-')
        print decode("".join(m)),
    print '\t'
