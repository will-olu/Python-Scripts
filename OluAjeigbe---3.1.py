
infile = open("data.txt") #locate file
outfile = open("SequentialSortAnswers","r") #create a file to house our data
def sequentialSort(infile, search_value): #function takes filename and searching value
    f = infile                                   #create a file variable
    string = f.readline()                                        #read  string into the file
    nums= string.split()                                       # split the string to make a list
    values=[]                                                   # creating a blank list for our values
    for i in nums:
        values.append(int(i))                            # appending values to the list
    count=0                                                       # loop counter
    comparison=1                                              # comparison counter
    size=len(values)                                       # number of values in the  list
    while count < size:   
        if values[count] == search_value:       # if list element is equal to searching element
            return comparison,count                    # return no of comparisons and position of searching element
        count+=1                                               # update loop counter
        comparison+=1                                     # update comparison counter
    return comparison,-1                    # return counter and -1 for unsucessfull search

outfile.write(str(comparison, count)) #store data in that file and write in the comparison and count values
outfile.close() # make sure to close the values to prevent any errors
