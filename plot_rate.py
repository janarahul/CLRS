import matplotlib.dates as mdates
import matplotlib.pyplot as plt
from matplotlib.animation import FuncAnimation
import pandas as pd

fig = plt.figure()
ax = fig.add_subplot(1,1,1)

def animation(i):
  data = pd.read_csv('data/gold_rates.csv',header=None)
  x = []
  y = []
  x = data[0].values
  y = data[1].values
  
  ax.clear()
  fig.autofmt_xdate()
  # xfmt = mdates.DateFormatter('%d-%m-%y %H:%M:%S')
  # ax.xaxis.set_major_formatter(xfmt)
  ax.plot(x, y)

animation = FuncAnimation(fig, func=animation, interval=1000)
plt.show()