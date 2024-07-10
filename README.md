# Sorting Visualizer 🎨🖥️
Welcome to the Sorting Visualizer project! This Java-based application visualizes various sorting algorithms, making it easier to understand how they work. 🧩✨

## Overview 📖
The Sorting Visualizer provides a graphical representation of several sorting algorithms, including Bubble Sort, Merge Sort, Selection Sort, Insertion Sort, Quick Sort, Heap Sort, and Radix Sort. With a user-friendly interface, you can easily switch between different algorithms and observe their sorting processes in real-time.

## Features 🎁
**Visual Sorting Algorithms:** See how different sorting algorithms work step-by-step.<br>
**Randomize Array:** Generate a new random array to sort.<br>
**User-Friendly Interface:** Easy-to-use buttons for each sorting algorithm.<br>
**Real-Time Visualization:** Watch the sorting process with smooth animations.

## Tech Stack 🛠️
- Java: Core language for the application.
- Swing: For building the graphical user interface (GUI).

## Libraries Imported 📚
```
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
```

## Use Cases 🎯
**Educational Tool:** Helps students and developers understand how different sorting algorithms work.<br>
**Presentation:** Useful for demonstrations and lectures on sorting algorithms.<br>
**Interactive Learning:** Engages users in learning algorithms through visual interaction.

## Functions and Functionalities 🔍
**Main Components**
- SortingVisualizer Class: Main class that sets up the GUI and handles user interactions.
- SortingPanel Class: Custom JPanel that draws the array and handles the visualization.

**Sorting Algorithms**
- BubbleSortRunnable: Implements the Bubble Sort algorithm.
- MergeSortRunnable: Implements the Merge Sort algorithm.
- SelectionSortRunnable: Implements the Selection Sort algorithm.
- InsertionSortRunnable: Implements the Insertion Sort algorithm.
- QuickSortRunnable: Implements the Quick Sort algorithm.
- HeapSortRunnable: Implements the Heap Sort algorithm.
- RadixSortRunnable: Implements the Radix Sort algorithm.

**User Interface**
- Styled Buttons: Custom buttons for each sorting algorithm and randomize function.
- Action Listeners: Handle button clicks and start sorting algorithms in new threads.

## Getting Started 🚀
**Prerequisites**<br>
- Java Development Kit (JDK): Make sure you have JDK installed on your machine.

**Running the Application**
- Clone the repository:

```
git clone https://github.com/yourusername/SortingVisualizer.git
```
- Navigate to the project directory:
```
cd SortingVisualizer
```
- Compile and run the application:
```
javac SortingVisualizer.java
java SortingVisualizer
```
## Screenshots 📸
