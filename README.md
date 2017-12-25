# Read-and-Parse-CSV

This repo contains console application solution from given challenge.The application reads from the attached file "Navigation.csv"
and it's content could look like this for example:

      ID;MenuName;ParentID;isHidden;LinkURL
      1;Company;NULL;False;/company
      2;About Us;1;False;/company/aboutus
      3;Mission;1;False;/company/mission
      11;ASD-1;9;True;/asd/a
      5;Client 2;7;False;/references/client2
      6;Client 1;7;False;/references/client1
      7;References;NULL;False;/references
      8;Client 1-1;6;False;/references/client1/deeper1
      6;Client 2-1;5;False;/references/client2
      10;ASD-3;9;True;/asd/c
      12;ASD-2;9;True;/asd/b
      9;ASD;Null;True;/asd
      4;Team;2;False;/company/aboutus/team


in that case, the content should be presented in the folowing manner:

          . Company
          .... About Us
          ....... Team
          .... Mission
          . References
          .... Client 1
          ....... Client 1-1
          .... Client 2
          .... Client 2-1       


The key points:
  - The menu items should be indented depending on the parent they belong under
  - Some items are hidden, and should not be presented
  - The items should be ordered alphabetically
