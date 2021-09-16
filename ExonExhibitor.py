codon_table =  {'UUU': 'F', 'CUU': 'L', 'AUU': 'I', 'GUU': 'V', \
                 'UUC': 'F', 'CUC': 'L', 'AUC': 'I', 'GUC': 'V', \
                 'UUA': 'L', 'CUA': 'L', 'AUA': 'I', 'GUA': 'V', \
                 'UUG': 'L', 'CUG': 'L', 'AUG': 'M', 'GUG': 'V', \
                 'UCU': 'S', 'CCU': 'P', 'ACU': 'T', 'GCU': 'A', \
                 'UCC': 'S', 'CCC': 'P', 'ACC': 'T', 'GCC': 'A', \
                 'UCA': 'S', 'CCA': 'P', 'ACA': 'T', 'GCA': 'A', \
                 'UCG': 'S', 'CCG': 'P', 'ACG': 'T', 'GCG': 'A', \
                 'UAU': 'Y', 'CAU': 'H', 'AAU': 'N', 'GAU': 'D', \
                 'UAC': 'Y', 'CAC': 'H', 'AAC': 'N', 'GAC': 'D', \
                 'UAA': 'Stop', 'CAA': 'Q', 'AAA': 'K', 'GAA': 'E', \
                 'UAG': 'Stop', 'CAG': 'Q', 'AAG': 'K', 'GAG': 'E', \
                 'UGU': 'C', 'CGU': 'R', 'AGU': 'S', 'GGU': 'G', \
                 'UGC': 'C', 'CGC': 'R', 'AGC': 'S', 'GGC': 'G', \
                 'UGA': 'Stop', 'CGA': 'R', 'AGA': 'R', 'GGA': 'G', \
                 'UGG': 'W', 'CGG': 'R', 'AGG': 'R', 'GGG': 'G'
                 }
def readfasta(lines):
    #creation of an empty set called seq to hold our seq that we will iterate
    seq = []
    #this set is empty and will hold the indices of the of the values being iterated over
    index = []
    #seqplast represents the seq which will be an empty set
    seqplast = ""
    #initializing the number of lines at 0
    numlines = 0
    #for loop to iterate over the values in the line of the rosalind file
    for i in lines:
        #this indent looks at the values that are present in the set if this specific character is present do the following
        if '>' in i:
            #this replaces the spaces and indents with blanks
            index.append(i.replace("\n", "").replace(">", ""))
            #this replaces the valeus in the seqplast that are going to become new lines with space
            seq.append(seqplast.replace("\n", ""))
            #this is the space that 
            seqplast = ""
            #this equation allows for the iteration over all of the string values
            numlines += 1
        else:
            #this else function will now look at the set and say that if there is a seqplast
            #value that it should be increased and that it should be incremented by the values being read replacing new lines with blank spaces
            seqplast = seqplast + i.replace("\n", "")
            #this is the increasing the number of lines until the value is complete
            numlines += 1
     #conditional to say that if the number of lines is equal continue to append and replace those new lines with blank space
        if numlines == len(lines):
            seq.append(seqplast.replace("\n", ""))
    seq = seq[1:]
    return index, seq
 
 #this function translates the seq that we created in the previous function
def translation(seq):
    i = 0
    p = ""
    #this while loop takes the 3 letter sequences and then create a codon
    while i < len(seq)/3 - 1:
        #create a value n that puts together a three letter sequence
        n = seq[3 * i] +seq[3*i+1] + seq[3*i+2]
        #store that codon value in r and relate it back to the codon table created
        r = codon_table[n]
        i += 1
        p = p + r
    return p
#reading in the fasta file
f = open(r'rosalind_splc (1).txt', 'r')
lines = f.readlines()
f.close()
(index, seq) = readfasta(lines)
#the total seq initialized at 0
totlaseq = seq[0]
 
introns = seq[1:]
#removal of unnecessary coding regions
for line in introns:
    n = len(line)
    i = 0
    while i < len(totlaseq) - n + 1:
        subseq = totlaseq[i:i + n]
        #identifying the sub sequence and creating a new sequence from the total seq and subseq
        if subseq == line: 
            newseq = totlaseq[:i] + totlaseq[i + n:]
            #our newseq becomes the total seq that will be iterated
            totlaseq = newseq 
        i += 1
#any RNA values will now be given the appropriate nucleotide Uracil
rnaseq = totlaseq.replace('T', 'U')
#our protein is that RNA translation of the DNA that we have processed
protein = translation(rnaseq)
print(protein)
f = open('output.txt', 'w')
 
f.write(protein)
 
f.close()
 
