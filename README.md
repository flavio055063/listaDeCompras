# 🛒 Lista de Compras (Android App)

Um aplicativo Android simples e funcional para gerenciar uma lista de compras. Permite **cadastrar, consultar, pesquisar e excluir itens**, utilizando **persistência de dados com Room**, arquitetura MVVM e boas práticas de UI/UX com RecyclerView e ViewModel.

---

## Funcionalidades

- ✅ Cadastrar novos itens com nome, quantidade, preço, número e descrição
- ✅ Listar todos os itens cadastrados
- ✅ Excluir itens da lista
- ✅ Pesquisar itens pelo nome
- ✅ Exibição do **valor total** dos itens na tela principal
- ✅ Persistência local usando **Room (SQLite)**

---

## Tecnologias e Arquitetura

- **Kotlin**
- **Android Jetpack**:
  - `Room` (persistência)
  - `ViewModel` + `LiveData`
  - `RecyclerView`
- **Material Design**: Floating Action Buttons (FAB), layout moderno
- Arquitetura: **MVVM** (Model-View-ViewModel)

---
## Estrutura do projeto:
├── data/                  # Entidade, DAO e banco de dados Room

│   ├── ItemEntity.kt

│   ├── ItemsDao.kt

│   ├── ItemsDatabase.kt

│   └── ItemEntityMapper.kt

│
├── model/                 # Model de domínio (ItemModel)

│   └── ItemModel.kt

│
├── ui/                    # Atividades e adaptadores RecyclerView

│   ├── MainActivity.kt

│   ├── AddItemActivity.kt

│   ├── SearchActivity.kt

│   └── ItemAdapter.kt

│

├── viewmodel/             # ViewModel com lógica de negócio

│   ├── ItemsViewModel.kt

│   └── ItemsViewModelFactory.kt


