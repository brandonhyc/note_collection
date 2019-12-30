# class Point():
# 	def __init__(self, x, y):
# 		self.x = x
# 		self.y = y
    
# if (hasShips(pointToCheck, pointToCheck):
    
    
def countShips(bottom_left, top_right):
  if not hasShips(bottom_left,top_right):
    return 0
  
  elif (bottom_left.x == top_right.x) and (bottom_left.y == top_right.y):
    return 1
  
  else:
    return 
    countShips(bottom_left,Point((bottom_left.x+top_right.x)//2,(bottom_left.y+top_right.y)//2))
    + countShips(Point((bottom_left.x+top_right.x)//2,(bottom_left.y+top_right.y)//2),top_right)
    + countShips(Point(bottom_left.x,(bottom_left.y+top_right.y)//2),Point((bottom_left.x+top_right.x)//2,top_right.y))
    + countShips(Point((bottom_left.x+top_right.x)//2,bottom_left.y),Point(top_right.x,(bottom_left.y+top_right.y)//2))