DNA_CODON_TABLE = {
    'TTT': 'F',     'CTT': 'L',     'ATT': 'I',     'GTT': 'V',
    'TTC': 'F',     'CTC': 'L',     'ATC': 'I',     'GTC': 'V',
    'TTA': 'L',     'CTA': 'L',     'ATA': 'I',     'GTA': 'V',
    'TTG': 'L',     'CTG': 'L',     'ATG': 'M',     'GTG': 'V',
    'TCT': 'S',     'CCT': 'P',     'ACT': 'T',     'GCT': 'A',
    'TCC': 'S',     'CCC': 'P',     'ACC': 'T',     'GCC': 'A',
    'TCA': 'S',     'CCA': 'P',     'ACA': 'T',     'GCA': 'A',
    'TCG': 'S',     'CCG': 'P',     'ACG': 'T',     'GCG': 'A',
    'TAT': 'Y',     'CAT': 'H',     'AAT': 'N',     'GAT': 'D',
    'TAC': 'Y',     'CAC': 'H',     'AAC': 'N',     'GAC': 'D',
    'TAA': '-',     'CAA': 'Q',     'AAA': 'K',     'GAA': 'E',
    'TAG': '-',     'CAG': 'Q',     'AAG': 'K',     'GAG': 'E',
    'TGT': 'C',     'CGT': 'R',     'AGT': 'S',     'GGT': 'G',
    'TGC': 'C',     'CGC': 'R',     'AGC': 'S',     'GGC': 'G',
    'TGA': '-',     'CGA': 'R',     'AGA': 'R',     'GGA': 'G',
    'TGG': 'W',     'CGG': 'R',     'AGG': 'R',     'GGG': 'G'
}

#creating the function for result in regards to S
def result(s):
    #split result with a space
    result = ''
    #spliting the lines being parsed in S
    lines = s.split()
    #creation of variable in lines at index 0
    dna = lines[0]
    #creation of a value that looks at the introns in the set
    introns = lines[1:]
    #creation of a for loop to parse the DNA sequences to find the intron values
    for intron in introns:
        #replacing dna witht the specific introns that are being found in the sequence
        dna = dna.replace(intron, '')
    #creation of a i variable that will iterate over the values in the range respective of the of the length of the DNA string and taking into account the codon values 
    for i in range(0, len(dna), 3):
        #setting that the codon value is the initial i value and the addition of another value three lengths over
        codon = dna[i:i+3]
        #
        protein = None
        if DNA_CODON_TABLE.has_key(codon):
            protein = DNA_CODON_TABLE[codon]
    
        if protein == '-':
            break

        if protein:
            result += protein

    return ''.join(list(result))


if __name__ == "__main__":

    small_dataset = """
                    ATGGTCTACATAGCTGACAAACAGCACGTAGCAATCGGTCGAATCTCGAGAGGCATATGGTCACATGATCGGTCGAGCGTGTTTCAAAGTTTGCGCCTAG
                    ATCGGTCGAA
                    ATCGGTCGAGCGTGT
                    """
    large_dataset = open('datasets/rosalind_splc.txt').read().strip()

    print result(large_dataset)
