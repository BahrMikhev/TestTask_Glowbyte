#include <iostream>
#include <fstream>
#include <stack>
using namespace std;

int main()
{
    fstream file;
    string s;
    file.open("input.txt");
    file >> s;
    file.close();
    int n = s.length();
    stack<char> st;
    bool answer = true;
    for (int i = 0; i < n; i++)
    {
        if (s[i] == '(' || s[i] == '[' || s[i] == '{')
        {
            st.push(s[i]);
        }
        else if (!st.empty())
        {
            if (s[i] == ')' && st.top() == '(')
            {
                st.pop();
            }
            else
            {
                if (s[i] == ']' && st.top() == '[')
                {
                    st.pop();
                }
                else
                {
                    if (s[i] == '}' && st.top() == '{')
                    {
                        st.pop();
                    }
                    else
                    {
                        answer = false;
                        break;
                    }
                }
            }
        }
        else
        {
            answer = false;
            break;
        }
    }
    if (answer && st.size() == 0)
    {
        cout << "TRUE";
    }
    else
    {
        cout << "FALSE";
    }
    return 0;
}