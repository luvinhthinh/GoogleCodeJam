from collections import deque

file = open(raw_input(), 'r')
noOfGames = int(file.readline())

def printGame(index, result) : 
  print 'Case #'+`index`+': '+ result
  
def solveGame_v1(C, I, input_items) :
  def cleanData() :
    return map(lambda x : int(x), input_items)
    
  items = cleanData()  
  solution = ""
  foundSolution = False
  n = len(items)
  
  for i in range(0, n-1):
    if not foundSolution : 
      val0 = items[i]
      if val0 < C : 
        for j in range(i+1, n):
          if val0 + items[j] == C :
            solution = `(i+1)` + " " + `(j+1)`
            foundSolution = True
            break
  return solution

def solveGame_v2(C, I, input_items) :
  solution = ""
  
  
  return solution

for game_index in range(0, noOfGames):
  C = int(file.readline())
  I = int(file.readline())
  items = file.readline().strip().split(" ")
  printGame(game_index+1, solveGame_v1(C, I, items))

