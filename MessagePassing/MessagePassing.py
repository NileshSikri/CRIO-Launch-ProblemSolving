def spiralOrder(rows,cols,matrix):
    res = []

    init_row = 0
    init_col = 0
    final_row = rows
    final_col = cols

    while(init_row<final_row and init_col<final_col):
        for i in range(init_col,final_col):
            res.append(matrix[init_row][i])
        init_row +=1
        for j in range(init_row,final_row):
            res.append(matrix[j][final_col-1])
        final_col -=1
        if(init_row<final_row):
            for i in range(final_col-1,init_col-1,-1):
                res.append(matrix[final_row-1][i])
        final_row -=1
        if(init_col<final_col):
            for j in range(final_row-1,init_row-1,-1):
                res.append(matrix[j][init_col])
            init_col +=1
    return res

# Implement your solution by completing the below function
def canMessageBePassed(n, maze):
    spiral = spiralOrder(n,n,maze)
    i,stre = 0,0
    while(i<len(spiral)):
        if(spiral[i]>=stre):
            stre = spiral[i]
            i+=1
        else:
            i+=1
            if(stre-1>0 and i<len(spiral)-1):
                stre-=1
            elif(stre-1>=0 and i==len(spiral)-1):
                return True
            else:
                return False
    if(stre>0):
        return True

if __name__ == '__main__':
    row = input().split()
    n = int(row[0])
    s = int(row[1])
    m = int(row[2])
    
    maze = [[0 for col in range(n)] for row in range(n)]
    maze[0][0] = s

    for i in range(m):
        perPersonInput = input().split()
        x = int(perPersonInput[0])
        y = int(perPersonInput[1])
        p = int(perPersonInput[2])
        maze[x][y] = max(maze[x][y],p)
        
    result = canMessageBePassed(n, maze)
    if (result == True):
        print ("Yes")
    else:
        print ("No")
