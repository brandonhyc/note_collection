
# Bootstrap

### web: bootswatch, bootply


### form 
* form-control -> input bar
* form-group -> input bar + label
* btn-group/btn-toolbar -> btns


## Form-control
Three type: default(inline->vertical), inline, vertical 
default settings: 
1. `div.form-group` as wrapper 
2. `.form-control` for each `input` 
3. put `checkbox` in `div.checkbox` with `label` 

```html
<form action="/action_page.php">
  <div class="form-group">
    <label for="email">Email address:</label>
    <input type="email" class="form-control" id="email">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" id="pwd">
  </div>
  <div class="checkbox">
    <label><input type="checkbox"> Remember me</label>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
```