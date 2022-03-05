import { 
  createItem, deleteItem, getAllItems,

} from './services/item';
import { 
  Box,
  Button,
  FormControl,
  FormControlLabel,
  Grid,
  List,
  ListItem,
  Paper, 
  styled, 
  TextField, 
  Typography 
} from '@material-ui/core';
import { useEffect, useMemo, useState } from 'react';
import { Item } from './models/item';

const PaddedPaper = styled(Paper)(() => ({
  padding: '2rem',
  margin: '1rem'
}));

const ColoredBox = styled(Box)(() => ({
  backgroundColor: '#313131',
  height: '100vh'
}));

const JustifiedGridItem = styled(Grid)(() => ({
  display: 'flex',
  justifyContent: 'flex-end'
}))

const makeItem : (title: string) => Item = (title) => {
  const item: Item = {
    itemId: '',
    title: title
  };
  return item;
};

function App() {
  const [items, setItems] = useState<any[]>([]);
  const [title, setTitle] = useState<string>('');

  useEffect(() => {
    getAllItems((data: any) => {
      setItems(data);
    }, onFailure);
  }, []);

  const itemsList = useMemo(() => {
    return (
      <List>
        {items.map((item, i) => (
          <ListItem key={i} alignItems='center'>
            <Grid container>
              <Grid item xs={6}>
                {item.title}
              </Grid>

              <JustifiedGridItem item xs={6}>
                <Button variant='outlined' onClick={() => deleteItem(item.itemId, (data) => {
                  setItems(items.filter(i => i.itemId !== item.itemId));
                }, onFailure)}>
                  delete
                </Button>
              </JustifiedGridItem>
            </Grid>
          </ListItem>
        ))}
      </List>
    )
  }, [items]);

  const onCreate = (data: any) => {
    setItems(items.concat(data));
  }

  const onFailure = (err: any) => {
    console.log(err);
  }

  return (
    <div>
      <ColoredBox>
        <Grid container>
          <Grid item xs ={12}>
            <PaddedPaper >
              <Typography variant='h3'>Manage your items</Typography>
            </PaddedPaper>
          </Grid>
        </Grid>
        
        <Grid container>
          <Grid item xs={12} md={6}>
            <PaddedPaper>
              {itemsList}
            </PaddedPaper>
          </Grid>

          <Grid item xs={12} md={6}>
            <PaddedPaper>
              <FormControl>
                <FormControlLabel 
                  label=""
                  value=""
                  control={
                    <TextField value={title} onChange={(ev) => setTitle(ev.target.value)}/>
                  }
                />
              </FormControl>
              <Button variant='contained' onClick={() => {
                  createItem(makeItem(title), onCreate, onFailure);
                  setTitle('');
              }}>
                save
              </Button>

              <Button onClick={() => setTitle('')}>
                reset
              </Button>
            </PaddedPaper>
          </Grid>
        </Grid>
      </ColoredBox>
    </div>
  );
}

export default App;
