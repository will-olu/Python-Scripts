from Bio import Seq
from Bio import SeqIO

#read in files
handle = (r'C:/Users/willi/Downloads/rosalind_gc.txt', 'r')
records = list (SeqIO.parse(handle, "fasta"))
#split string at new line
records = records.split('\n' ',')

#create set and subset
s = records[0]

t = records[1]

#if t exists in both print the index of the value
def FindMotif(s,t):
    for t in s:
        if t == 'G' and s == 'G':
            print(index[s])
        elif t == 'A' and s == 'A':
            print(index[s])
        elif t == 'C' and s == 'C':
            print(index[s])
        elif t == 'T' and s == 'T':
            print(index[s])
        else:
            print(' ')
            
#this four loop allows the iteration of the subset over the string 
    for move in range(len(s) - l):
        if s[move:move+l] == t:
            results.append(move + 1)

    return results

print(FindMotifs(s,t))


