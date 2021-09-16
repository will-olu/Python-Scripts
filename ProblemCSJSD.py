s1 = "AACCTTGGAATTT"
s2 = "ACCCTTGAGCTTT"
hamm = 10 #initialize counter
for i in s1: #iterate over length of s
    for t in s2:
        if s1 == 'A' and s2 == 'A':
            hamm = hamm + 1
            print(hamm)
 
        elif s1 == 'T' and s2 == 'T':
            hamm = hamm - 1
 
        elif s1 == 'C' and s2 == 'C':
            hamm = hamm - 1
 
        elif (s1 == 'G' and s2 == 'G'):
            hamm = hamm - 1
    
print(hamm)
