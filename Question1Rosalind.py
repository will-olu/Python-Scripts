from Bio.Seq import Seq
#from Bio import SeqIO


#GC content Counter

handle = open(r'C:/Users/willi/Downloads/rosalind_gc.txt(1)', "r")

records = ((SeqIO.parse(handle, "fasta")))
sequence = handle.read()

handle.close()


sequence = list(sequence)

#initialize length value at 0
length = 0

#creates a for loop to iterate over strings
for seq in sequence:

    if sequence[length] == '>':

        #del sequence[length:length + 14] #this is another way of slicing off the FASTA header sequence.

        length = length + 1
    
        sequence = ''.join(sequence)

#compares total sequence over the total GC to get GC content
total_bp = sequence.count('A') + sequence.count('T') + sequence.count('G') + sequence.count('C')
#similar to the code we used in class to count GC data
total_GC = sequence.count('G') + sequence.count('C')
#code we used in class modified to meet the requirements including decimal values
GC_content = (float(total_GC) / float(total_bp)) * 100

print(GC_identity)
print(GC_content)
