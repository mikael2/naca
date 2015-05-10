# What is Naca? -->[click here](Naca0201.md) #

## NacaRT - JMX Console - Close site ##

### Close site handling (# App\_Close) ###

> Closing the online site can be done in two ways:
  * Manually
  * Planned

> The handling of the manually closure is realized via the following JMX screen:

> The bean #App\_Close is displayed when the site is open.
> The tab "Attributes" is giving a summary of the conditions defining the launch status:
> `A_ApplicationmanualStatus`: manual launch status
> `B0_ApplicationStandardStatus`: status linked with the use of the standard calendar configuration file
> `B1_ApplicationcustomStatus`: Status linked with the use of the custom calendar configuration file
> `C_ApplicationCurrentstatus`: final launch status
> `__ManualCloseReason`: allows to fill in the field "value" giving the reason why the site is going to be closed.
> Beware, this value must be multilingual. Do not forget to validate the field with pressing "Enter".

> The next screen is allowing to close the site manually, or to reload the calendar files:

> Handling site open (# App\_Open).

> When the site is closed, the bean # App\_Close is not displayed, but the bean # App\_Open is displayed in the left column.
> We then cannot have the beans # App\_Open and # App\_Close displayed at the same time:

> The same informations can be accesible in # App\_Close.

> The tab "Operations" is: