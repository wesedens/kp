"""
split binary string into blocks of n
"""
import math
import numpy as np
import re

def findTriples(s):
    return re.findall(r'((\w)\2{2,})', s)

def repeating(s):
    return re.findall(r"(.+?)(?=\1)",s)