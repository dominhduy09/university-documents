clc;
x_values = 0:10;

% Evaluate functions using yourName_YourID_func1
result_f1 = NguyenDaoAnhKhoi_EEEEIU22067_func1(x_values);

% Evaluate functions using yourName_YourID_func2
result_f2 = NguyenDaoAnhKhoi_EEEEIU22067_func2(x_values);

% Evaluate function using yourName_YourID_fano
result_fano = fano(x_values);

% Display the results
disp('Results for f1(x):')
disp(result_f1)

disp('Results for f2(x):')
disp(result_f2)

disp('Results for fano(x):');
disp(result_fano)
