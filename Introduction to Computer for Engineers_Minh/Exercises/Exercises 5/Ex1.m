% Given vector
V = [17 8 12 15 6 11 9 18 16 10 13 19];

% a. Calculate length, sizes, number of rows, and number of columns
vector_length = length(V);
vector_size = size(V);

num_rows = size(V, 1);
num_cols = size(V, 2);
% [num_rows, num_cols] = size(V)

% b. Calculate sum of vector elements
sum_of_elements = sum(V);

% c. Calculate average of vector
average = mean(V);

% e. Calculate differences between adjacent elements
differences = diff(V);

% d. Calculate the standard deviation of this vector
sum_squared_diff = sum((V - average).^2);
N = numel(V);
std_dev = sqrt(sum_squared_diff / (N - 1));

% Display results
disp(['Length of vector: ' num2str(vector_length)]);
disp(['Size of vector: ' num2str(vector_size)]);
disp(['Number of rows: ' num2str(num_rows)]);
disp(['Number of columns: ' num2str(num_cols)]);
disp(['Sum of vector elements: ' num2str(sum_of_elements)]);
disp(['Average of vector: ' num2str(average)]);
disp(['Standard deviation of the vector: ' num2str(std_dev)]);
disp('Differences between adjacent elements:');
disp(differences);

