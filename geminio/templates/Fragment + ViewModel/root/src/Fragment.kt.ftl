package ${packageName}

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.R
import com.alish.boilerplate.databinding.${fragmentBinding}
import com.alish.boilerplate.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ${fragmentName} : BaseFragment<${viewModelName}, ${fragmentBinding}>(
    R.layout.${fragmentLayoutResName}
) {

    override val viewModel: ${viewModelName} by viewModels()
    override val binding by viewBinding(${fragmentBinding}::bind)
}