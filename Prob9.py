
infile = "rosalind_prot.txt"

outfile = open("ini9_out.txt")

for codon in splitted_rna:
    rna = open(infile)

    splitted_rna.append([3])
    if codon == 'AUG':
        print('M', end="")
    elif codon == 'GCC' or codon == 'GCG' or codon == 'GCU' or codon == 'GCA':
        print('A', end="")
    elif codon == 'CGU' or codon == 'CGC' or codon == 'CGA' or codon == 'CGG':
        print('R', end="")
    elif codon == 'CCC' or codon == 'CCU' or codon == 'CCA' or codon == 'CCG':
        print('P', end="")
    elif codon == 'ACC' or codon == 'ACU' or codon == 'ACA' or codon == 'ACG':
        print('T', end="")
    elif codon == 'GAA' or codon == 'GAG':
        print('E', end="")
    elif codon == 'GAU' or codon == 'GAC':
        print('E', end="")
    elif codon == 'AUU' or codon == 'AUC' or codon == 'AUA':
        print('I', end="")

outfile.write(str(codon))

outfile.close()
