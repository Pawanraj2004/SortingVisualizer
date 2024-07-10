import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortingVisualizer extends JFrame {
    private int[] array;
    private SortingPanel panel;
    private JButton bubbleSortButton;
    private JButton mergeSortButton;
    private JButton selectionSortButton;
    private JButton insertionSortButton;
    private JButton quickSortButton;
    private JButton heapSortButton;
    private JButton radixSortButton;
    private JButton randomizeButton;
    public SortingVisualizer() {
        array = generateRandomArray(31);
        panel = new SortingPanel(array);
        bubbleSortButton = createStyledButton("Bubble Sort");
        mergeSortButton = createStyledButton("Merge Sort");
        selectionSortButton=createStyledButton("Selection Sort");
        insertionSortButton= createStyledButton("Insertion Sort");
        quickSortButton=createStyledButton("Quick Sort");
        heapSortButton= createStyledButton("Heap Sort");
        radixSortButton=createStyledButton("Radix Sort");
        randomizeButton = createRandomButton("Randomize");

        bubbleSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new BubbleSortRunnable()).start();
            }
        });

        mergeSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new MergeSortRunnable()).start();
            }
        });

        selectionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new SelectionSortRunnable()).start();
            }
        });

        insertionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new InsertionSortRunnable()).start();
            }
        });

        quickSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new QuickSortRunnable()).start();
            }
        });

        heapSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new HeapSortRunnable()).start();
            }
        });

        radixSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new RadixSortRunnable()).start();
            }
        });

        randomizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                array = generateRandomArray(31);
                panel.setArray(array);
                panel.repaint();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(bubbleSortButton);
        buttonPanel.add(mergeSortButton);
        buttonPanel.add(selectionSortButton);
        buttonPanel.add(insertionSortButton);
        buttonPanel.add(quickSortButton);
        buttonPanel.add(heapSortButton);
        buttonPanel.add(radixSortButton);
        buttonPanel.add(randomizeButton);

        JPanel headingPanel = new JPanel();
        headingPanel.setBackground(Color.WHITE);
        JLabel headingLabel=new JLabel("SORTING VISUALIZER");
        headingLabel.setFont(new Font("Arial",Font.BOLD,24));
        headingLabel.setForeground(Color.BLACK);
        headingPanel.add(headingLabel);

        this.getContentPane().setBackground(Color.BLACK);
        panel.setBackground(Color.WHITE);
        buttonPanel.setBackground(Color.WHITE);

        this.add(panel, BorderLayout.CENTER);
        this.add(headingPanel, BorderLayout.SOUTH);
        this.add(buttonPanel, BorderLayout.NORTH);
        this.setSize(875, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(Color.LIGHT_GRAY);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorderPainted(true);
        button.setOpaque(true);
        button.getBorder();
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return button;
    }
    private JButton createRandomButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(Color.RED);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(true);
        button.setOpaque(true);
        button.getBorder();
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return button;
    }

    private int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 250);
        }
        return array;
    }

    private class SortingPanel extends JPanel {
        private int[] array;
        public SortingPanel(int[] array) {
            this.array = array;
        }
        public void setArray(int[] array) {
            this.array = array;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            for (int i = 0; i < array.length; i++) {
                g.fillRect(i * 27, getHeight() - array[i], 50, array[i]);
            }
        }
    }

    private class BubbleSortRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - 1 - i; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        panel.repaint();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private class MergeSortRunnable implements Runnable {
        @Override
        public void run() {
            mergeSort(array, 0, array.length - 1);
        }

        private void mergeSort(int[] array, int left, int right) {
            if (left < right) {
                int mid = (left + right) / 2;
                mergeSort(array, left, mid);
                mergeSort(array, mid + 1, right);
                merge(array, left, mid, right);
                panel.repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void merge(int[] array, int left, int mid, int right) {
            int n1 = mid - left + 1;
            int n2 = right - mid;

            int[] leftArray = new int[n1];
            int[] rightArray = new int[n2];

            for (int i = 0; i < n1; i++) {
                leftArray[i] = array[left + i];
            }
            for (int i = 0; i < n2; i++) {
                rightArray[i] = array[mid + 1 + i];
            }

            int i = 0, j = 0;
            int k = left;

            while (i < n1 && j < n2) {
                if (leftArray[i] <= rightArray[j]) {
                    array[k] = leftArray[i];
                    i++;
                } else {
                    array[k] = rightArray[j];
                    j++;
                }
                k++;
            }

            while (i < n1) {
                array[k] = leftArray[i];
                i++;
                k++;
            }

            while (j < n2) {
                array[k] = rightArray[j];
                j++;
                k++;
            }
        }
    }

    private class SelectionSortRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < array.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] < array[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
                panel.repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private class InsertionSortRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i < array.length; i++) {
                int key = array[i];
                int j = i - 1;
                while (j >= 0 && array[j] > key) {
                    array[j + 1] = array[j];
                    j--;
                    panel.repaint();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                array[j + 1] = key;
            }
        }
    }

    private class QuickSortRunnable implements Runnable {
        @Override
        public void run() {
            quickSort(array, 0, array.length - 1);
        }
    
        private void quickSort(int[] array, int low, int high) {
            if (low < high) {
                int pi = partition(array, low, high);
                quickSort(array, low, pi - 1);
                quickSort(array, pi + 1, high);
                panel.repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    
        private int partition(int[] array, int low, int high) {
            int pivot = array[high];
            int i = (low - 1);
            for (int j = low; j < high; j++) {
                if (array[j] < pivot) {
                    i++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            int temp = array[i + 1];
            array[i + 1] = array[high];
            array[high] = temp;
            return i + 1;
        }
    }

    private class HeapSortRunnable implements Runnable {
        @Override
        public void run() {
            heapSort(array);
        }
    
        private void heapSort(int[] array) {
            int n = array.length;
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(array, n, i);
            }
            for (int i = n - 1; i >= 0; i--) {
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;
                panel.repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                heapify(array, i, 0);
            }
        }
    
        private void heapify(int[] array, int n, int i) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < n && array[left] > array[largest]) {
                largest = left;
            }
            if (right < n && array[right] > array[largest]) {
                largest = right;
            }
            if (largest != i) {
                int swap = array[i];
                array[i] = array[largest];
                array[largest] = swap;
                heapify(array, n, largest);
            }
        }
    }

    private class RadixSortRunnable implements Runnable {
        @Override
        public void run() {
            radixSort(array);
        }
    
        private void radixSort(int[] array) {
            int max = getMax(array);
            for (int exp = 1; max / exp > 0; exp *= 10) {
                countSort(array, exp);
                panel.repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    
        private int getMax(int[] array) {
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            return max;
        }
    
        private void countSort(int[] array, int exp) {
            int n = array.length;
            int[] output = new int[n];
            int[] count = new int[10];
            for (int i = 0; i < n; i++) {
                count[(array[i] / exp) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                output[count[(array[i] / exp) % 10] - 1] = array[i];
                count[(array[i] / exp) % 10]--;
            }
            for (int i = 0; i < n; i++) {
                array[i] = output[i];
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SortingVisualizer();
            }
        });
    }
}