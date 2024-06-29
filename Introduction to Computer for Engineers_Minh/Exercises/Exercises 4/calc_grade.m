
function [ave_grade] = calc_grade(grades)
  N_exams = length(grades);
  ave_grade = sum(grades) / N_exams;
  disp('The average of grade is: ');
  disp(ave_grade);

  if (ave_grade < 50)
    disp('The student did not pass the course!');
   else
    disp('The student passed the course!');
  endif

endfunction
