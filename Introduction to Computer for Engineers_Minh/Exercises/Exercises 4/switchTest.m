grade = input('Enter your grade: ', 's');

  switch (grade)
    case {'A' 'a'}
      fprintf('Excellent\n');
    case 'B'
      fprintf('Well done\n');
    case 'C'
      fprintf('Good\n');
    case 'D'
      fprintf('You passed\n');
    case 'F'
      fprintf('Better try again\n');
    otherwise
      fprintf('Invalid\n');
  endswitch

